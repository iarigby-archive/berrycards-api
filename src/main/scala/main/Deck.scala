package main

/** collection of cards
  * @param cards cards
  */
case class Deck(name: String, cards: Seq[Card]=Seq.empty) {

}

object StartingData {
  val startingDecks = Seq(
    Deck("Linux commands", Seq(
      Card("#!/bin/bash is commonly called as", "shebang, hashbang"),
      Card("what does w command do?", "print quick summary of every user logged into a computer"),
      Card("world’s largest non-commercial Linux distribution", "Debian"),
      Card( "commands for inserting a module into kernel are", "insmod, modprobe")
    )),
    Deck("Computer Networks", Seq(
      Card("Which of the OSI layers deals with the shape of connectors for network connections?", "physical"),
      Card("Which of the layers is most similar between the OSI and TCP network models", "TCP Internetwork Layer and OSI Network Layer"),
      Card("What layer does the TCP/IP Secure Sockets Layer map to in the OSI network model?", "Session and Presentation Layers")
    ))
  )
}