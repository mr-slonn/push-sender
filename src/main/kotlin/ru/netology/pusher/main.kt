package ru.netology.pusher

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.Message
import java.io.FileInputStream


fun main() {
    val options = FirebaseOptions.builder()
        .setCredentials(GoogleCredentials.fromStream(FileInputStream("fcm.json")))
        .build()

    FirebaseApp.initializeApp(options)

    val message = Message.builder()
        .putData("action", "LIKE")
        .putData("content", """{
          "userId": 1,
          "userName": "Vasiliy",
          "postId": 2,
          "postAuthor": "Netology"
        }""".trimIndent())
        .setToken("cULvg_rvT1qzyIF9bvBPSd:APA91bFDqqo51s07fh-YmcTAoVr_evFsMpeT_pn_yp8xIYwryJuR_gLNP9yDmmY49zm2YcApK3hbfhCrDZVMRBcYbJhU_XWzvMQ2kUlRzJsxbz4Wh2srbT39Rb0HTGTA95ma-gTuyYya")
        .build()

    val messageBig = Message.builder()
        .putData("action", "NEW_POST")
        .putData("content", """{
          "postId": 3,
          "postAuthor": "Netology",
          "content":"Таймбоксинг — отличный способ навести порядок в своём календаре и разобраться с делами, которые долго откладывали на потом. Его главный принцип — на каждое дело заранее выделяется определённый отрезок времени. В это время вы работаете только над одной задачей, не переключаясь на другие. Собрали советы, которые помогут внедрить таймбоксинг 👇🏻"
        }""".trimIndent())
        .setToken("cULvg_rvT1qzyIF9bvBPSd:APA91bFDqqo51s07fh-YmcTAoVr_evFsMpeT_pn_yp8xIYwryJuR_gLNP9yDmmY49zm2YcApK3hbfhCrDZVMRBcYbJhU_XWzvMQ2kUlRzJsxbz4Wh2srbT39Rb0HTGTA95ma-gTuyYya")
        .build()

    FirebaseMessaging.getInstance().send(messageBig)
}
