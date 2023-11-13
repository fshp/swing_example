package dev.fshp.swing_example

import javax.swing.UIManager

object Main extends App {
  UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName)
  val window = new MainWindow
  window.pack()
  window.setSize(800, 600)
  window.setLocationRelativeTo(null)
  window.setVisible(true)
}
