package stryker4s.command

import stryker4s.command.config.ProcessRunnerConfig
import stryker4s.config.Config
import stryker4s.mutants.applymutants.ActiveMutationContext
import stryker4s.mutants.applymutants.ActiveMutationContext.ActiveMutationContext
import stryker4s.mutants.findmutants.SourceCollector
import stryker4s.report.Reporter
import stryker4s.run.process.ProcessRunner
import stryker4s.run.{Stryker4sRunner}
import stryker4s.command.runner.ProcessMutantRunner

class Stryker4sCommandRunner(processRunnerConfig: ProcessRunnerConfig) extends Stryker4sRunner {
  override val mutationActivation: ActiveMutationContext = ActiveMutationContext.envVar

  override def resolveRunner(collector: SourceCollector, reporter: Reporter)(implicit
      config: Config
  ): ProcessMutantRunner = new ProcessMutantRunner(processRunnerConfig.testRunner, ProcessRunner(), collector, reporter)

}
