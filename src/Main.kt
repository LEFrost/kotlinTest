import matchFeatureStr
import matchAccessNo
import Data

fun main(args: Array<String>) {
    val list = listOf<Data>(
            Data(1, "10628888", "xw", true, false),
            Data(2, "1062888801", "xw", false, false),
            Data(3, "1062888801", "xw1", false, true),
            Data(4, "10628888", "01xw", true, true),
            Data(5, "10628888", null, false, false)
    )
    val accessNo = readLine()?:""
    val featureStr = readLine()?:""
    val resutl = list.matchAccessNo(accessNo).matchFeatureStr(featureStr)
    println("查询结果:${resutl?.seq ?: "匹配失败!!!"}")
}
