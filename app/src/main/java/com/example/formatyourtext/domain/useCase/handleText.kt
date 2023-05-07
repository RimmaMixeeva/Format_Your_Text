package com.example.formatyourtext.domain.useCase

import com.example.formatyourtext.presentation.viewModel.MainViewModel

fun handleText(mainViewModel: MainViewModel): String {
    val settings = mainViewModel.readAllData.value
    val allRegexes = mainViewModel.readAllRegex.value
    settings?.forEach { item ->
        if (item.isOn == 1) {
        var regexes = allRegexes?.filter { one -> one.settingId == item.id}?.sortedBy { it.priority }
            for (i in 0 until (regexes?.size?:0)) {
                val text = mainViewModel.liveText.value ?: ""
                mainViewModel.setNewText(
                        text.replace(
                            Regex(regexes?.get(i)?.regexBefore ?: ""),
                            regexes?.get(i)?.regexAfter ?: "",
                        )
                    )
            }
        }


    }
    return mainViewModel.liveText.value ?: ""
}