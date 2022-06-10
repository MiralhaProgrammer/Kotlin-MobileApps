package com.example.motivacional

data class Phrase(val description: String, val categoryId: Int)

class Mock {
    private val happy = 3
    private val android = 2
    private val home = 1

    val mListPhrase = listOf<Phrase>(
        Phrase("Não sabendo que era impossível, foi lá e fez.", happy),
        Phrase("Você não é derrotado quando perde, você é derrotado quando desiste!", happy),
        Phrase("Quando está mais escuro, vemos mais estrelas!", happy),
        Phrase("Insanidade é fazer sempre a mesma coisa e esperar um resultado diferente.", happy),
        Phrase("Não pare quando estiver cansado, pare quando tiver terminado.", happy),
        Phrase("O que você pode fazer agora que tem o maior impacto sobre o seu sucesso?", happy),
        Phrase("A melhor maneira de prever o futuro é inventá-lo.", home),
        Phrase("Você perde todas as chances que você não aproveita.", home),
        Phrase("Fracasso é o condimento que dá sabor ao sucesso.", home),
        Phrase(" Enquanto não estivermos comprometidos, haverá hesitação!", home),
        Phrase("Se você não sabe onde quer ir, qualquer caminho serve.", home),
        Phrase("Se você acredita, faz toda a diferença.", home),
        Phrase("Riscos devem ser corridos, porque o maior perigo é não arriscar nada!", home)
    )

    fun getPhrase(categoryId: Int): String {
        var randomNumber = 0
        when(categoryId){
            1 -> {
                randomNumber = (6..12).random()
            }

            2 -> {
                randomNumber = (0..12).random()
            }

            3 -> {
                randomNumber = (0..5).random()
            }
        }
        return mListPhrase[randomNumber].description
    }
}