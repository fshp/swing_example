package dev.fshp.swing_example

import java.awt.{Dimension, GridLayout, Image}
import javax.imageio.ImageIO
import javax.swing.{JFrame, WindowConstants}

class MainWindow extends JFrame {
  private val left = new ImageViewer {
    override def loadImage(n: Int): Image = {
      ImageIO.read(getClass.getResource(s"/dev/fshp/swing_example/left/left_${n % 2 + 1}.png"))
    }
  }

  private val right = new ImageViewer {
    override def loadImage(n: Int): Image = {
      ImageIO.read(getClass.getResource(s"/dev/fshp/swing_example/right/right_${n % 2 + 1}.png"))
    }
  }

  locally {
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE)
    setTitle("Image example")

    setLayout(new GridLayout())
    add(left)
    add(right)
  }
}
