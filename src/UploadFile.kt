import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.File

fun uploadFiles(directoryPath: String, url: String, accessToken: String) {
    val directory = File(directoryPath)
    if (!directory.isDirectory) {
        throw IllegalArgumentException("Provided path is not a directory")
    }
    val client = OkHttpClient()
    directory.listFiles()?.forEach { file ->
        if (file.isFile) {
            val token = "Bearer $accessToken"
            val request = Request.Builder()
                .url(url)
                .addHeader("Authorization", token)
                .post(
                    MultipartBody.Builder()
                        .setType(MultipartBody.FORM)
                        .addFormDataPart(
                            "file",
                            file.name,
                            file.asRequestBody("image/*".toMediaTypeOrNull())
                        )
                        .build()
                )
                .build()
            client.newCall(request).execute().use { response ->
                if (!response.isSuccessful) {
                    throw IllegalStateException("Unexpected response code: ${response.code}")
                }
                else{
                    println()
                }
            }
        }
    }


}

fun main() {
    uploadFiles(
        directoryPath = "C:\\Users\\Administrator\\Pictures\\photos",
        url = "http://localhost:3000/media/upload_media",
        accessToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkIjoiN2FmYmEyYjYtNTg3ZS00MWJmLWFlNTQtYTU3ZWY1NWJiMjJhIiwidXNlckVtYWlsIjoiZW1haWwxQG1haWwuY29tIiwiaWF0IjoxNjgxMTMwNjAxLCJleHAiOjE2ODE5OTQ2MDF9.wKb0feB4B5HF6gVEvjSr7XsRJ1cEmpvr2tt_3p-C55o"
    )
}
