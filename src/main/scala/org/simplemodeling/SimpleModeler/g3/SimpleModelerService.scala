package org.simplemodeling.SimpleModeler.g3

import org.goldenport.g3._
import org.goldenport.g3.atom._
import org.goldenport.g3.messages._
import org.goldenport.g3.messages.http._
import org.goldenport.g3.events.Getted
import org.apache.commons.fileupload.FileUpload
import org.apache.commons.fileupload.FileItem
import org.apache.commons.fileupload.servlet.ServletFileUpload
import org.simplemodeling.SimpleModeler.SimpleModeler
import org.goldenport.entity.datasource.ObjectDataSource
import com.sun.corba.se.spi.legacy.connection.GetEndPointInfoAgainException
import org.goldenport.entity.content.BinaryContent

/**
 * @since   Nov.  8, 2011
 * @version Nov. 14, 2011
 * @author  ASAMI, Tomoharu
 */
class SimpleModelerService extends G3Application with UseRecord {
  port("/") html(<p>SimpleModeler Service</p>)

  port("/sm") agent {
    case p: Post => Command.action(p)
    case x => {
      _peek(x)
      "OK"
    }
  }

  private def _peek(x: AnyRef) = {
    println(x)
  }
}

object Command {
  import scala.collection.JavaConverters._

  def action(p: Post): AnyRef = {
    try {
      val files = p.getAttachments()
      val file = files(0)
      val sm = new SimpleModeler(Array())
      sm.useFirstLeafExporter()
      val result = sm.generateDiagram(file.name, file.get())
      result match {
        case Some(r) => r match {
          case b: BinaryContent => Getted(file.name, b)
          case _ => "no result"
        }
        case None => "no result"
      }
    } catch {
      case e => _exception(e);throw e
    }
  }

  private def _exception(e: Throwable) {
    println("exception: " + e)    
  }
}

object Main {
  def main(args: Array[String]) {
    val app = new SimpleModelerService()
    val args2 = args ++ Array("-g3.server -g3.server.port:8777")  
    app.open(args2: _*)
    app.run();
  }
}