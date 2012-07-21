package models

import anorm._
import anorm.SqlParser._
import play.api.db._
import play.api.Play.current

case class BookItem(title: String)

object BookItem{

    def search(keyword:String): List[BookItem] = {
        BookItem("bar") :: BookItem("foo") :: Nil
    }

}
