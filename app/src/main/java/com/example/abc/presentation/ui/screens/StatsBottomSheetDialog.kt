package com.example.abc.presentation.ui.screens

import android.content.Context
import android.view.LayoutInflater
import android.widget.TextView
import com.example.abc.util.CustomItemUtils
import com.example.abc.R
import com.example.abc.domain.model.Item
import com.google.android.material.bottomsheet.BottomSheetDialog

class StatsBottomSheetDialog(private val context: Context) {

    fun show(items: List<Item>) {
        val topCharacters = CustomItemUtils.topThreeFrequentCharactersFromTitles(items)

        val bottomSheetDialog = BottomSheetDialog(context)
        val view = LayoutInflater.from(context).inflate(R.layout.bottom_sheet_statistics, null)
        bottomSheetDialog.setContentView(view)

        val textViewStats: TextView = view.findViewById(R.id.textViewStats)
        val statsText = topCharacters.joinToString(separator = "\n") { "${it.first}: ${it.second} times" }
        textViewStats.text = statsText

        bottomSheetDialog.show()
    }
}
