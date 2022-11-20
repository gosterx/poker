package org.example.application
package error

import cats.Show

trait ApplicationError extends Throwable {
  def message: String
}

object ApplicationError {
  implicit val show: Show[ApplicationError] = Show.show(error => s"Error: ${error.message}")
}
