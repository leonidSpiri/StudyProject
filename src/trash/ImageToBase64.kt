package trash

import java.io.*
import java.util.*
import javax.imageio.ImageIO

class ImageToBase64 {
    fun imageToBase64(imagePath: String): String {
        val image = ImageIO.read(File(imagePath))
        val imageByteArray = ByteArrayOutputStream().use {
            ImageIO.write(image, "jpg", it)
            it.toByteArray()
        }
        return Base64.getEncoder().encodeToString(imageByteArray)
    }

    @Throws(IOException::class)
    fun readFromInputStream(filePath: String): String {
        val targetStream: InputStream = FileInputStream(File(filePath))
        val resultStringBuilder = StringBuilder()
        BufferedReader(InputStreamReader(targetStream)).use { br ->
            var line: String?
            while (br.readLine().also { line = it } != null) {
                resultStringBuilder.append(line).append("\n")
            }
        }
        return resultStringBuilder.toString()
    }
}

//val scanner = Scanner(System.`in`)
//val imgByte = ImageToBase64().imageToBase64(scanner.next())
//File("/Users/admin/Downloads/mac.txt").writeText(imgByte)
//println("Done!")
//println(ImageToBase64().readFromInputStream(scanner.next()))
//println("result = " + CalcApp(input = scanner.nextLine()).doCalculate())