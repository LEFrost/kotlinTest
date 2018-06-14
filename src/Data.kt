class Data(val seq: Int, val accessNo: String,
           val featureStr: String?, val ANCheckFlag: Boolean, val FSCheckFlag: Boolean)

fun List<Data>.matchAccessNo(number: String): List<Data> {
    var result = mutableListOf<Data>()
    for (item in this) {
        if (item.ANCheckFlag) {
            if (number == item.accessNo) result.add(item)
        } else {
            if (number.contains(item.accessNo)) result.add(item)
        }
    }
    return result
}

fun List<Data>.matchFeatureStr(content: String): Data? {
    val tempList = ArrayList<Data>()
    for (item in this) {
        if (item.FSCheckFlag) {
            if (content == item.featureStr) return item
        } else {
            if (item.featureStr == null) tempList.add(item)
            else if (content.contains(item.featureStr)) tempList.add(item)
        }
    }
    if (tempList.size == 0) return null
    else if (tempList.size == 1) return tempList[0]
    else
        return tempList.maxBy { it.featureStr?.length ?: 0 }
}