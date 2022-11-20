package org.example.application
package error

trait ApplicationError extends Throwable{
  def message: String
}
