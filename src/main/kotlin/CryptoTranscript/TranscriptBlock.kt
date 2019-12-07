package CryptoTranscript

import com.sun.org.apache.xpath.internal.operations.Bool
import org.apache.commons.codec.digest.DigestUtils
import java.io.File
import java.util.*

class TranscriptBlock(val index: Int,
                      var previousHash: String,
                      var transcriptData: Any,
                      val proofOfWork: Int,
                      val fork:Boolean,
                      var flag: String) {

    var hash = computeHash()


     fun computeHash(): String {
         val timestamp: Long = Date().time

         //val input = (index.toString() + previousHash + timestamp + File("/Users/preeth   iprabhakar/Documents/src/SoftwareDesign/Test_PDF.pdf")).toByteArray()
         val input = (index.toString() + previousHash +transcriptData +timestamp+ proofOfWork).toByteArray()

        return DigestUtils.sha256Hex(input)
    }
}
