package trash

/*
В последнее время на стримах школы мобильных разработчиков часто стали запускать гусей в чат. Естественно, преподаватели из-за этого могут
  пропустить важные вопросы. Для борьбы с этим было принято решение ограничивать возможность отправки сообщения тем юзерам, которые хотя бы
  k раз упомянули в своих сообщениях слово goose. Так как вручную мониторить это достаточно сложно, вас попросили написать программу,
  которая по перечисленным сообщениям определит список тех пользователей, к кому требуется применить санкции.
  */
fun main() {
    val (n, k) = readln().split(" ").map(String::toInt)
    val userMentions = mutableMapOf<String, Int>()

    for (i in 1..n) {
        val nickname = readln()
        val message = readln()
        val mentions = message.split(" ").count { it == "goose" }

        userMentions[nickname] = userMentions.getOrDefault(nickname, 0) + mentions
    }

    val sanctionedUsers = userMentions.filterValues { it >= k }.keys.toList()

    println(sanctionedUsers.size)
    sanctionedUsers.sorted().forEach { println(it) }
}
