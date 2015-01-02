/**
 * Copyright (c) 2002-2015 "Neo Technology,"
 * Network Engine for Objects in Lund AB [http://neotechnology.com]
 *
 * This file is part of Neo4j.
 *
 * Neo4j is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.neo4j.cypher.internal.compiler.v2_0.functions

import org.neo4j.cypher.internal.compiler.v2_0._
import ast.convert.ExpressionConverters._
import commands.{expressions => commandexpressions}
import symbols._

case object Sign extends Function with SimpleTypedFunction {
  def name = "sign"

  val signatures = Vector(
    Signature(argumentTypes = Vector(CTInteger), outputType = CTInteger),
    Signature(argumentTypes = Vector(CTFloat), outputType = CTInteger)
  )

  def asCommandExpression(invocation: ast.FunctionInvocation) =
    commandexpressions.SignFunction(invocation.arguments(0).asCommandExpression)
}
