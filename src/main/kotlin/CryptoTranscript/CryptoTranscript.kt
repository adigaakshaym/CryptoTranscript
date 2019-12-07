package CryptoTranscript


import io.javalin.Javalin.*

val cryptoTranscript= TranscriptBlockchain

fun main(args: Array<String>) {
    val app = start(4444)
    app.get("/getTranscriptBlocks") { ctx ->
        ctx.json(cryptoTranscript.chain )
        ctx.header("Access-Control-Allow-Origin", "*");
    }


    app.post("/transcriptBlocks/mine") { ctx ->
        var queryString=0
        if(ctx.queryString()!=null) {
            queryString= ctx.queryString()!!.split("=")[1].toInt()

            val minedTranscriptBlock = cryptoTranscript.updateTranscript(queryString,ctx.body())
            ctx.json(minedTranscriptBlock)
            ctx.header("Access-Control-Allow-Origin", "*");
        }


       else {
            val minedTranscriptBlock = cryptoTranscript.mineTranscriptBlock(ctx.body())
            ctx.json(minedTranscriptBlock)
            ctx.header("Access-Control-Allow-Origin", "*");
        }
    }

    app.post("/tamperBlocks") { ctx ->
        var queryString=0
        if(ctx.queryString()!!.length>0) {
            queryString= ctx.queryString()!!.split("=")[1].toInt()
        }

        val minedTranscriptBlock = cryptoTranscript.tamperExistingTranscriptBlock(queryString, ctx.body())
        ctx.json(minedTranscriptBlock)
       ctx.header("Access-Control-Allow-Origin", "*");
    }

    app.post("/transcriptBlocks/fork") { ctx ->

        cryptoTranscript.createfork1()
        cryptoTranscript.createfork2()
        ctx.json( cryptoTranscript.chain_fork_1 + cryptoTranscript.chain_fork_2 )
        ctx.header("Access-Control-Allow-Origin", "*");
    }

    app.get("/transcriptBlocks/longestchain") { ctx ->
        cryptoTranscript.findlongestchain()
        ctx.json( cryptoTranscript.chain )
        ctx.header("Access-Control-Allow-Origin", "*");

    }

}
