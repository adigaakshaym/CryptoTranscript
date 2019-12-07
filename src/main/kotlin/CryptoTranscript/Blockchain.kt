package CryptoTranscript

object TranscriptBlockchain {
    val chain = mutableListOf<TranscriptBlock>()
    val chain_fork_1 = mutableListOf<TranscriptBlock>()
    val chain_fork_2 = mutableListOf<TranscriptBlock>()
    val longest_chain = mutableListOf<TranscriptBlock>()
    val latestTranscriptBlock: TranscriptBlock
        get() = chain.last()

    var chain_length: Int
        get() = 0
        set(value) = TODO()
    val transcriptData = null

    init {




    }

    fun createfork1(): TranscriptBlock {

        var proofOfWork = produceProofOfWork(latestTranscriptBlock.proofOfWork)
        var chain_len=chain.size
        var latestTranscriptBlock = TranscriptBlock(chain.size+1, chain[2].hash, "1st fork "+(chain_len+1)+" block", proofOfWork, false, "green" )
        chain_fork_1.add(latestTranscriptBlock)
        proofOfWork = produceProofOfWork(latestTranscriptBlock.proofOfWork)
        latestTranscriptBlock = TranscriptBlock(chain.size+2, latestTranscriptBlock.hash, "1st fork "+(chain_len+2)+" block", proofOfWork, false, "green" )
        chain_fork_1.add(latestTranscriptBlock)
        proofOfWork = produceProofOfWork(latestTranscriptBlock.proofOfWork)
        latestTranscriptBlock = TranscriptBlock(chain.size+3, latestTranscriptBlock.hash, "1st fork "+(chain_len+3)+" block", proofOfWork, false, "green" )
        chain_fork_1.add(latestTranscriptBlock)

        return latestTranscriptBlock


    }
    fun createfork2(): TranscriptBlock {

        var proofOfWork = produceProofOfWork(latestTranscriptBlock.proofOfWork)
        var chain_len=chain.size
        var latestTranscriptBlock = TranscriptBlock(chain.size+1, chain[2].hash, "2nd fork "+(chain_len+1)+" block", proofOfWork, false, "green" )
        chain_fork_2.add(latestTranscriptBlock)
        proofOfWork = produceProofOfWork(latestTranscriptBlock.proofOfWork)
        latestTranscriptBlock = TranscriptBlock(chain.size+2, latestTranscriptBlock.hash, "2nd fork "+(chain_len+2)+" block", proofOfWork, false, "green" )
        chain_fork_2.add(latestTranscriptBlock)
        proofOfWork = produceProofOfWork(latestTranscriptBlock.proofOfWork)
        latestTranscriptBlock = TranscriptBlock(chain.size+3, latestTranscriptBlock.hash, "2nd fork "+(chain_len+3) +" block", proofOfWork, false, "green" )
        chain_fork_2.add(latestTranscriptBlock)
        proofOfWork = produceProofOfWork(latestTranscriptBlock.proofOfWork)
        latestTranscriptBlock = TranscriptBlock(chain.size+4, latestTranscriptBlock.hash, "2nd fork "+(chain_len+4) +" block", proofOfWork, false, "green" )
        chain_fork_2.add(latestTranscriptBlock)
        proofOfWork = produceProofOfWork(latestTranscriptBlock.proofOfWork)
        latestTranscriptBlock = TranscriptBlock(chain.size+5, latestTranscriptBlock.hash, "2nd fork "+(chain_len+5) +" block", proofOfWork, false, "green" )
        chain_fork_2.add(latestTranscriptBlock)
        return latestTranscriptBlock


    }
    fun mineTranscriptBlock(data: Any): TranscriptBlock {
        findlongestchain()
        if(chain.size>0) {
            val proofOfWork = produceProofOfWork(latestTranscriptBlock.proofOfWork)
            val block = TranscriptBlock(chain.size, latestTranscriptBlock.hash, data, proofOfWork, false, "green")

            addNewTranscriptBlock(block)

        reapplyFlags()

        }

        else
        {
            chain.add(TranscriptBlock(0, "0", data, 0, false,"green"))
        }
        return latestTranscriptBlock
    }

     /*fun tamperExistingTranscriptBlock(index: Int,data: Any) {
         chain[index].transcriptData=data

         chain[index].hash=chain[index].computeHash()

    }*/
     fun reapplyFlags() {
 var i=0
         while(i < chain.size-1)
         {

             if(chain[i+1].previousHash.equals(chain[i].hash)) {


                     chain[i+1].flag = "green"


             }
             i=i+1

         }

     }

    fun findlongestchain()  {


        if(chain_fork_1!=null && chain_fork_2 !=null)
        {
            if(chain_fork_1.size > chain_fork_2.size) chain.addAll(chain_fork_1)
            else
                chain.addAll(chain_fork_2)
        }


    }

    fun tamperExistingTranscriptBlock(index: Int,data: Any): TranscriptBlock {
        chain[index].transcriptData=data

        chain[index].hash=chain[index].computeHash()
        if(!chain[index+1].previousHash.equals(chain[index].computeHash())) {
            var i=index
            while(i<chain.size) {
                chain[i].flag = "red"
                i=i+1
            }
        }

        return chain[index+1]
    }

    private fun addNewTranscriptBlock(block: TranscriptBlock) {
        if (isNewTranscriptBlockValid(block)) chain.add(block)
    }


    private fun produceProofOfWork(previousPow: Int, difficulty: Int = 1): Int {
        var proof = previousPow + 1
        val nonce = 19 * difficulty
        while ((proof + previousPow) % nonce != 0) {
            proof += 1
        }
        return proof
    }

    private fun isNewTranscriptBlockValid(newBlock: TranscriptBlock): Boolean =
            ((newBlock.index == latestTranscriptBlock.index + 1) || (newBlock.previousHash == latestTranscriptBlock.hash))

    fun updateTranscript(index: Int, data: Any): TranscriptBlock {
        chain[index].transcriptData=data
if(index>0)
chain[index].previousHash=chain[index-1].hash
        chain[index].hash=chain[index].computeHash()
        reapplyFlags()
         return chain[index]

    }

}
