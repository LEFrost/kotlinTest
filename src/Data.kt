 class Data(val seq: Int, val accessNo: String,
           val featureStr: String?, val ANCheckFlag: Boolean, val FSCheckFlag: Boolean)

fun List<Data>.matchAccessNo(number: String): List<Data> {
    var result = mutableListOf<Data>()//创建一个数组用来存储结果并返回
    for (item in this) {//遍历规则表
        if (item.ANCheckFlag) {//判断是否需要精确匹配
            if (number == item.accessNo) result.add(item)//将匹配成功结果加入结果列表
        } else {
            if (number.contains(item.accessNo)) result.add(item)
        }
    }
    return result//返回结果
}

fun List<Data>.matchFeatureStr(content: String): Data? {
    val tempList = ArrayList<Data>()//创建一个临时数组，存储可能成功的数据
    for (item in this) {//遍历规则表
        if (item.FSCheckFlag) {//判断是否需要精确匹配
            if (content == item.featureStr) return item//匹配成功直接返回Data对象
        } else {
            if (item.featureStr == null) tempList.add(item)//如果featureStr为空直接加入可能成功的列表
            else if (content.contains(item.featureStr)) tempList.add(item)//模糊匹配成功加入可能成功数据
        }
    }
    if (tempList.size == 0) return null//没有匹配成功
    else if (tempList.size == 1) return tempList[0]//只有一个则直接返回
    else
        return tempList.maxBy { it.featureStr?.length ?: 0 }//寻找模糊成功匹配最长的featureStr，当featureStr为空时长度为0
}