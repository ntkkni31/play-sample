package services

import javax.inject._
import org.slf4j.LoggerFactory
import play.api.inject.ApplicationLifecycle

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Success}


@Singleton
class Global @Inject() (appLifecycle: ApplicationLifecycle) {

  protected val _logger = LoggerFactory.getLogger("Logger")

  {
    _logger.info("Application Start.")

    initialize.onComplete{
      case Success(_) => _logger.info("initialize success.")
      case Failure(_) => _logger.error("initialize failure.")
    }
  }

  private def initialize(): Future[Boolean] = Future {
    _logger.info("start initialization.")

    // ...

    true
  }

}