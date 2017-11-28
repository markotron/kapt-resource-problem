package com.markotron.processor

import com.markotron.annotation.MyAnnotation
import javax.annotation.processing.AbstractProcessor
import javax.annotation.processing.RoundEnvironment
import javax.lang.model.SourceVersion
import javax.lang.model.element.Element
import javax.lang.model.element.TypeElement
import javax.tools.Diagnostic

class MyProcessor : AbstractProcessor() {

  override fun process(annotations: MutableSet<out TypeElement>, env: RoundEnvironment): Boolean {

    fun printMsg(msg: String) =
      processingEnv.messager.printMessage(Diagnostic.Kind.MANDATORY_WARNING, msg)

    fun printClassName(e: Element) =
      printMsg(e.simpleName.toString())

    fun loadResourceFile(name: String) = this::class.java.classLoader.getResource(name).readText()

    val annotatedClasses = env.getElementsAnnotatedWith(MyAnnotation::class.java)
    annotatedClasses.forEach { printClassName(it) }

    printMsg(loadResourceFile("test.txt"))

    return true
  }

  override fun getSupportedAnnotationTypes() = setOf(MyAnnotation::class.java.canonicalName)
  override fun getSupportedSourceVersion() = SourceVersion.latestSupported()
}
