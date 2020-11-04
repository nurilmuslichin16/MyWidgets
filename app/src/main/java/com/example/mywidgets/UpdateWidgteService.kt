package com.example.mywidgets

import android.app.job.JobParameters
import android.app.job.JobService
import android.appwidget.AppWidgetManager
import android.content.ComponentName
import android.widget.RemoteViews

class UpdateWidgteService: JobService() {

    override fun onStartJob(jobParameters: JobParameters?): Boolean {
        val manager = AppWidgetManager.getInstance(this)
        val view = RemoteViews(packageName, R.layout.random_number_widget)
        val thenWidget = ComponentName(this, RandomNumberWidget::class.java)
        val lastUpdate = "Random: " + NumberGenerator.generator(100)
        view.setTextViewText(R.id.appwidget_text, lastUpdate)
        manager.updateAppWidget(thenWidget, view)
        jobFinished(jobParameters, false)
        return true
    }

    override fun onStopJob(p0: JobParameters?): Boolean = false

}