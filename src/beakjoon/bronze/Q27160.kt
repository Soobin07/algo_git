fun main() {
    var N = readLine()!!.toInt()
    // var N = t_N?.toIntOrNull()?:0
    var map = hashMapOf("BANANA" to 0, "PLUM" to 0, "STRAWBERRY" to 0, "LIME" to 0)
    for (i in 1..N){
        var tmp = readLine()!!.split(" ")
        map.put(tmp[0], (map.get(tmp[0])!!.toInt() + tmp[1]!!.toInt()))
    }
    var flug = false
    map.forEach{(name, cnt) -> 
        if (cnt == 5){
            flug = true
        }
    }
    print(if (flug) "YES" else "NO")
}
