package com.improve_future.jxconvert

import org.json.JSONObject
import org.json.XML

object Main {
    fun convertJsonStringToXmlString(jsonString: String, tagName: String? = null): String {
        return XML.toString(JSONObject(jsonString), tagName)
    }

    fun convertJsonToXmlString(json: JSONObject, tagName: String? = null): String {
        return XML.toString(json, tagName)
    }

    fun convertXmlStringToJson(xmlString: String): JSONObject {
        return XML.toJSONObject(xmlString)
    }

    fun convertXmlStringToJsonString(xmlString: String, indentFactor: Int = 0): String {
        return convertXmlStringToJson(xmlString).toString(indentFactor)
    }

    @JvmStatic
    fun main(vararg args: String) {
println(convertXmlStringToJsonString(
        "<a>a</a><f /><a>b</a><a>c</a><b><a>1</a><b>2</b></b><c>true</c>"))
// {"a":["a","b","c"],"b":{"a":1,"b":2},"c":true,"f":""}
println(convertJsonStringToXmlString("""
    {"a":["a","b","c"],"b":{"a":1,"b":2},"c":true,"f":""}
    """))
// <a>a</a><a>b</a><a>c</a><b><a>1</a><b>2</b></b><c>true</c><f/>
println(convertXmlStringToJsonString(
    "<p a=\"1\"><a a=\"1\">a</a><a>b</a><a>c</a><b><a>1</a><b>2</b></b><c>true</c></p>"))
// {"p":{"a":[1,{"a":1,"content":"a"},"b","c"],"b":{"a":1,"b":2},"c":true}}
println(convertJsonStringToXmlString("""
    {"a":[1,{"a":1,"content":"a"},"b","c"],"b":{"a":1,"b":2},"c":true}
    """, "p"))
// <p><a>1</a><a><a>1</a>a</a><a>b</a><a>c</a><b><a>1</a><b>2</b></b><c>true</c></p>
    }
}