package dev.fshp.swing_example

import java.awt.{Graphics, Image}
import javax.swing.JComponent

class ScalableImage extends JComponent {
  private var image: Option[Image] = None

  def setImage(img: Image): Unit = {
    image = Some(img)
    repaint()
  }

  override def paintComponent(g: Graphics): Unit = {
    image.foreach { i =>
      val scale  = math.min(getHeight.toFloat / i.getHeight(null), getWidth.toFloat / i.getWidth(null))
      val left   = ((getWidth  - i.getWidth(null)  * scale)  / 2).toInt
      val top    = ((getHeight - i.getHeight(null) * scale)  / 2).toInt
      val width  = (i.getWidth(null)  * scale).toInt
      val height = (i.getHeight(null) * scale).toInt
      g.drawImage(i, left, top, width, height, null)
    }
  }
}
