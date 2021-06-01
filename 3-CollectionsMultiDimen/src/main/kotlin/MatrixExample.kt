class MatrixExample {
    companion object {

        fun matrix() {

            var matrix = MutableList<MutableList<String>>(6) {
                MutableList(6) { ".\t" }
            }

            matrix[4][5] = "x"

           x@ for (x in 0..matrix.lastIndex) {
               println("searching in row $x")
               y@ for (y in 0..matrix.lastIndex) {
                   if(matrix[x][y] == "x") {
                       println("found ${matrix[x][y]} at $x, $y coordinate")
                       break@x
                   }
                }
                println("")
            }


        }
    }
}