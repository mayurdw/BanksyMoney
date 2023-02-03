package com.mayur.banksymoney.ui.transactionitem.elements

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import com.jaikeerthick.composable_graphs.color.LinearGraphColors
import com.jaikeerthick.composable_graphs.composables.LineGraph
import com.jaikeerthick.composable_graphs.data.GraphData
import com.jaikeerthick.composable_graphs.style.LineGraphStyle

@Preview(
    widthDp = 240,
    heightDp = 320,
    showBackground = true
)
@Composable
fun GraphicalSummary(
    modifier: Modifier = Modifier
) {
    LineGraph(
        xAxisData =
        listOf("Sun", "Mon", "Tues", "Wed", "Thur", "Fri", "Sat").map {
            GraphData.String(it)
        }, // xAxisData : List<GraphData>, and GraphData accepts both Number and String types
        yAxisData = listOf(200, 40, 60, 450, 700, 30, 50),
        style = LineGraphStyle(
            colors = LinearGraphColors(
                lineColor = MaterialTheme.colorScheme.onBackground,
                pointColor = MaterialTheme.colorScheme.onBackground,
                fillGradient = Brush.verticalGradient(
                    listOf(
                        MaterialTheme.colorScheme.onBackground,
                        MaterialTheme.colorScheme.background
                    )
                )
            )
        )
    )
}