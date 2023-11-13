package dev.fshp.swing_example

import java.awt.{BorderLayout, Image}
import javax.swing.{JButton, JPanel}

abstract class ImageViewer extends JPanel {
  private val image = new ScalableImage
  private val button = new JButton("Next")

  private var index = 0

  def loadImage(n: Int): Image

  private def nextImage(): Unit = {
    index += 1
    image.setImage(loadImage(index))
  }

  locally {
    setLayout(new BorderLayout)
    add(image, BorderLayout.CENTER)
    add(button, BorderLayout.PAGE_END)
    button.addActionListener { _ =>
      nextImage()
      image.repaint()
    }
    nextImage()
  }
}
