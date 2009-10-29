package org.apache.maven.plugin.nar;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import java.io.File;

import org.apache.maven.plugin.MojoFailureException;

/**
 * Abstract GNU Mojo keeps configuration
 * 
 * @author Mark Donszelmann
 */
public abstract class AbstractGnuMojo
    extends AbstractResourcesMojo
{
    /**
     * Use GNU goals on Windows
     * 
     * @parameter expresssion="nar.gnu.useonwindows" default-value="false"
     * @required
     */
    private boolean gnuUseOnWindows;
    
    /**
     * Source directory for GNU style project
     * 
     * @parameter expression="${basedir}/src/gnu"
     * @required
     */
    protected File gnuSourceDirectory;

    /**
     * Directory in which gnu sources are copied and "configured"
     * 
     * @parameter expression="${project.build.directory}/nar/gnu"
     * @required
     */
    private File gnuTargetDirectory;

    /**
     * @return
     * @throws MojoFailureException
     */
    protected File getGnuAOLSourceDirectory()
        throws MojoFailureException
    {
        return new File( getGnuAOLDirectory(), "src" );
    }

    /**
     * @return
     * @throws MojoFailureException
     */
    protected File getGnuAOLTargetDirectory()
        throws MojoFailureException
    {
        return new File( getGnuAOLDirectory(), "target" );
    }

    /**
     * @return
     * @throws MojoFailureException
     */
    private File getGnuAOLDirectory()
        throws MojoFailureException
    {
        return new File( gnuTargetDirectory, getAOL().toString() );
    }
    
    /**
     * Returns true if we do not want to use GNU on Windows
     * 
     * @return
     */
    protected boolean useGnu() {
        return (gnuUseOnWindows || !NarUtil.getOS( null ).equals( OS.WINDOWS ));
    }
}
