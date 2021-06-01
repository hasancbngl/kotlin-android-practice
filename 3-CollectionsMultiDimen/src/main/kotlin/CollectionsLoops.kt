class CollectionsLoops {
    companion object Coll {
        fun print() {
            val matrix = MutableList<MutableList<String>>(5) {
                MutableList(5) { "A" }
            }

            for (row in 0..matrix.lastIndex) {
                for (column in 0..matrix.lastIndex) {
                    matrix[row][column] = "row:$row column: $column \t"
                    print(matrix[row][column])
                }
                println("")
            }

            println("\n\n************")
            //exit stragy done with using label

            row@ for (row in 0..5) {

                column@ for (column in 0..5) {
                    if (column == 4 && row ==0) {
                        break@row
                    }
                    print("x\t")
                }
                println()
            }
        }
    }
}