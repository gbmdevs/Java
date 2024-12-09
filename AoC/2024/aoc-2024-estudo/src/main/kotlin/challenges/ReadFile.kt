package challenges

object ReadFile {
    fun readFileInput(name: String): String {
        val filePath = this::class.java.classLoader.getResource(name)?.path
                ?: throw IllegalArgumentException("Arquivo não encontrado em resources")
        return filePath
    }
}