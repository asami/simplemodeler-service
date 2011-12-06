package org.simplemodeling.SimpleModeler.g3

import org.goldenport.g3._
import org.goldenport.g3.atom._
import org.goldenport.g3.messages._
import org.goldenport.g3.messages.http._
import org.goldenport.g3.events.Getted
import org.goldenport.entity.datasource.ObjectDataSource
import org.goldenport.entity.content.BinaryContent
import org.simplemodeling.SimpleModeler.SimpleModeler
import org.simplemodeling.SimpleModeler.SimpleModelerDescriptor

/**
 * @since   Nov.  8, 2011
 * @version Dec.  6, 2011
 * @author  ASAMI, Tomoharu
 */
class SimpleModelerService extends G3Application {
  title = "SimpleModeler"
  summary = <div>SimpleModeler service produces various artifacts from a SimpleModeling model.</div>

  port("/diagram",
      Description(
          "Diagram", "SimpleModeler Diagram Service",
          <div locale="en">SimpleModeler diagram service produces a class diagram from a mindmap modeled by MindmapModeling.</div>,
          Schema(
              (Symbol("source.package"), XString, MZeroOne),
              ('_1, XBase64Binary)))
  ) agentpf {
    case p: Post => Post("diagram", p)
  } invoke('sm)

  goldenport('sm, SimpleModelerDescriptor)
}
