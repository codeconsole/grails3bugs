import example.*

class BootStrap {

    def init = { servletContext ->
        FlashCardSet set = new FlashCardSet(name:'Commerical 172RG')
        FlashCard f = new FlashCard(question: 'question', answer: 'answer').save(flush: true)
        set.addToFlashCards(f)
        set.save(flush: true)
    }
    def destroy = {
    }
}
