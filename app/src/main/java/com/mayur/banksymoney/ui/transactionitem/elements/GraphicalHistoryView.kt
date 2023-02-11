package com.mayur.banksymoney.ui.transactionitem.elements

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.jaikeerthick.composable_graphs.color.LinearGraphColors
import com.jaikeerthick.composable_graphs.composables.LineGraph
import com.jaikeerthick.composable_graphs.data.GraphData
import com.jaikeerthick.composable_graphs.style.LineGraphStyle

@Preview(
    device = Devices.DEFAULT,
    showBackground = true
)
@Composable
private fun PreviewGraphicalSummary() {
    GraphicalHistoryView(
        xAxisLabelStrings = listOf(
            "Sun", "Mon", "Tues"
        ),
        yAxisValueIntegers = listOf(
            200.0, 172.2, 210.2
        )
    )
}

@Composable
fun GraphicalHistoryView(
    xAxisLabelStrings: List<String>,
    yAxisValueIntegers: List<Double>
) {
    LineGraph(
        xAxisData = xAxisLabelStrings.map {
            GraphData.String(it)
        },
        yAxisData = yAxisValueIntegers,
        style = LineGraphStyle(
            colors = LinearGraphColors(
                lineColor = MaterialTheme.colorScheme.onBackground,
                pointColor = MaterialTheme.colorScheme.background,
                clickHighlightColor = MaterialTheme.colorScheme.onBackground,
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