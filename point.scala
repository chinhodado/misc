class Point(
    // adding `val` here automatically creates
    // public accessor methods named `x` and `y`
    val x: Double, val y: Double,
    addToGrid: Boolean = false
) {
  // import functions/vars from companion object
  import Point._
 
  if (addToGrid)
    grid.add(this)
 
  def this() {
    this(0.0, 0.0)
  }
 
  def distanceToPoint(other: Point) =
    distanceBetweenPoints(x, y, other.x, other.y)
}
 
object Point {
  // private/protected members shared between
  // class and companion object
  private val grid = new Grid()
 
  def distanceBetweenPoints(x1: Double, y1: Double,
      x2: Double, y2: Double) = {
    val xDist = x1 - x2
    val yDist = y1 - y2
    math.sqrt(xDist*xDist + yDist*yDist)
  }
}
