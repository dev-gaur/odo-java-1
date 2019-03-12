package com.lordofthejars.odo.maven;

import com.lordofthejars.odo.core.Odo;
import com.lordofthejars.odo.core.commands.ProjectDeleteCommand;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

@Mojo(name = "create-project")
public class OdoProjectDeleteMojo extends AbstractMojo {

    protected Odo odo = null;

    @Parameter
    protected String projectName;

    @Parameter(defaultValue = "true")
    Boolean withForce;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        if(odo == null) {
            odo = new Odo();
        }
        ProjectDeleteCommand.Builder builder = odo.deleteProject(projectName);

        if (withForce!= null && !withForce) {
            builder.withForce(false);
        }

        ProjectDeleteCommand projectDeleteCommand = builder.build();

        projectDeleteCommand.execute();
    }
}