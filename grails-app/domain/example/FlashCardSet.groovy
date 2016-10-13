package example

class FlashCardSet {

    String name
    static hasMany = [flashCards: FlashCard]

    static constraints = {
    	name()
    }
}
