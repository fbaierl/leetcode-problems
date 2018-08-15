package easy

/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example 1:

Input: "()"
Output: true
Example 2:

Input: "()[]{}"
Output: true
Example 3:

Input: "(]"
Output: false
Example 4:

Input: "([)]"
Output: false
Example 5:

Input: "{[]}"
Output: true
 */

import scala.collection.mutable

object ValidParantheses {

  def main(args: Array[String]): Unit = {
    println("Should be true: " + isValid("()"))
    println("Should be true: " + isValid("(){}[]"))
    println("Should be false: " + isValid("(]"))
    println("Should be true: " + isValid("([{}])"))
    println("Should be false: " + isValid("([)]"))
    println("Should be false: " + isValid("["))
  }

  def isOpeningParanthesis(c: Char): Boolean = {
    c match {
      case '{'  | '(' |  '[' => true
      case _ => false
    }
  }

  def isClosingParanthesis(c: Char): Boolean = {
    c match {
      case '}' | ')' | ']' => true
      case _ => false
    }
  }

  def getOpeningCounterpart(c: Char): Char = {
    c match {
      case '}' => '{'
      case ')' => '('
      case ']' => '['
      case _ => throw new RuntimeException("Not a opening paranthesis: " + c)
    }
  }

  def isValid(s: String): Boolean = {
    val openingParantheses = mutable.Stack[Char]()
    s.toCharArray.foreach(c => {
      if(isOpeningParanthesis(c)){
        openingParantheses.push(c)
      } else if (isClosingParanthesis(c)){
        if(openingParantheses.isEmpty ||
            openingParantheses.pop() != getOpeningCounterpart(c)){
          return false
        }
      }
    })
    openingParantheses.isEmpty
  }

}
