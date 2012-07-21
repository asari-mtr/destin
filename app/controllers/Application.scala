package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._

object Application extends Controller {

  val bookItemForm = Form(
    "query" -> nonEmptyText
  )
  
  def index = Action {
    Ok(views.html.index("Your new application is ready.", bookItemForm))
  }

  def query() = Action { implicit request =>
    bookItemForm.bindFromRequest.fold (
      errors => BadRequest(views.html.index("foo", bookItemForm)),
      query => {
        println(request);
        Ok(views.html.index(query, bookItemForm))
      }
    )
  }

  def search(keyword: String) = Action {
    Ok(views.html.index(keyword, bookItemForm))
  }
  
}
