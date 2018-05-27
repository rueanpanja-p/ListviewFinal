package com.final223.final223

/**
 * Created by Heroter on 5/26/2018.
 */
import android.content.Context
import org.json.JSONException
import org.json.JSONObject

class Heroes(
        val title: String,
        val detail: String,
        val pic: String) {
    companion object {
        fun getHeroesFromFile(filename: String, context: Context): ArrayList<Heroes> {
            val recipeList = ArrayList<Heroes>()

            try {
                // Load data
                val jsonString = loadJsonFromAsset("heroes.json", context)
                val json = JSONObject(jsonString)
                val recipes = json.getJSONArray("heroes")

                // Get Recipe objects from data
                (0 until recipes.length()).mapTo(recipeList) {
                    Heroes(recipes.getJSONObject(it).getString("title"),
                            recipes.getJSONObject(it).getString("detail"),
                            recipes.getJSONObject(it).getString("pic"))
                }
            } catch (e: JSONException) {
                e.printStackTrace()
            }

            return recipeList
        }

        private fun loadJsonFromAsset(filename: String, context: Context): String? {
            var json: String? = null

            try {
                val inputStream = context.assets.open(filename)
                val size = inputStream.available()
                val buffer = ByteArray(size)
                inputStream.read(buffer)
                inputStream.close()
                json = String(buffer, Charsets.UTF_8)
            } catch (ex: java.io.IOException) {
                ex.printStackTrace()
                return null
            }

            return json
        }
    }
}