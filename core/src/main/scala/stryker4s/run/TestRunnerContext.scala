package stryker4s.run

import better.files.File

trait TestRunnerContext {
  val workingDir: File
}
