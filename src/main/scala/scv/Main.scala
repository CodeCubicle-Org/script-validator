package scv

import org.rogach.scallop.*
import pt.kcry.sha.Sha3_256

import java.nio.file.{Files, Path}

final case class Config(arguments: Seq[String]) extends ScallopConf(arguments):
//  val apples = opt[Int](required = true)
//  val bananas = opt[Int]()
  val directoryPath = trailArg[String]()
  verify()

object Main:
  def main(args: Array[String]): Unit =
    val config = Config(args)

    println(s"Arguments: ${config.directoryPath()}")
    val rootPath = Path.of(config.directoryPath())
    val paths = rootPath.toFile.list()
    println(paths.toSeq)

    val hashes = paths.map(rootPath.resolve).filter(_.toFile.isFile).map: path =>
      Sha3_256.hash(Files.readAllBytes(path))

    println(hashes.toSeq.map(_.length))
