package br.com.example.simple.compose

import br.com.example.simple.constants.*
import br.com.zup.beagle.core.CornerRadius
import br.com.zup.beagle.core.PositionType
import br.com.zup.beagle.core.ServerDrivenComponent
import br.com.zup.beagle.core.Style
import br.com.zup.beagle.ext.applyStyle
import br.com.zup.beagle.ext.unitPercent
import br.com.zup.beagle.ext.unitReal
import br.com.zup.beagle.widget.action.Navigate
import br.com.zup.beagle.widget.action.Route
import br.com.zup.beagle.widget.core.*
import br.com.zup.beagle.widget.layout.ComposeComponent
import br.com.zup.beagle.widget.layout.Container
import br.com.zup.beagle.widget.navigation.Touchable
import br.com.zup.beagle.widget.ui.Image
import br.com.zup.beagle.widget.ui.ImagePath
import br.com.zup.beagle.widget.ui.Text

class ProductEditCardTemplate(
        val image: String,
        val priceText: String,
        val productName: String,
        val description: String
) : ComposeComponent {
    override fun build(): ServerDrivenComponent {
        return Touchable(onPress = listOf(Navigate.PushView(route = Route.Remote(url = "/store"))), child =
        Container(children =
        listOf(
                Image(path = ImagePath.Local.justMobile(image))
                        .applyStyle(style = Style(
                                margin = EdgeValue(top = 10.unitReal()),
                                size = Size(width = 200.unitReal(), height = 200.unitReal()),
                                cornerRadius = CornerRadius(50.0),
                                flex = Flex(
                                        alignSelf = AlignSelf.CENTER
                                )
                        )
                        ),
                Text(text = productName, styleId = STYLE_TEXT_SYSTEM_LIGHT, alignment = TextAlignment.LEFT, textColor = LIGHT_GREY).applyStyle(style = Style(
                        margin = EdgeValue(top = 10.unitReal(), left = 5.unitReal(), right = 5.unitReal())
                )
                ),
                Text(text = priceText, styleId = STYLE_TEXT_BOLD_SYSTEM_20, alignment = TextAlignment.LEFT, textColor = LIGHT_GREY).applyStyle(style = Style(
                        margin = EdgeValue(top = 10.unitReal(), left = 5.unitReal(), right = 5.unitReal())
                )),
                Text(text = description, styleId = STYLE_TEXT_SYSTEM_LIGHT, alignment = TextAlignment.LEFT, textColor = LIGHT_GREY).applyStyle(style = Style(
                        margin = EdgeValue(top = 10.unitReal(), left = 5.unitReal(), right = 5.unitReal())
                )),
                createicon(EDITAR).applyStyle(
                        Style(
                                size = Size(width = 30.unitReal(), height = 30.unitReal()),
                                margin = EdgeValue(top = 15.unitReal(), left = 15.unitReal()),
                                positionType = PositionType.ABSOLUTE
                        )
                ),
                createicon(EXIT).applyStyle(
                        Style(
                                size = Size(width = 30.unitReal(), height = 30.unitReal()),
                                margin = EdgeValue(top = 15.unitReal()),
                                position = EdgeValue(right = 15.unitReal()),
                                flex = Flex(alignSelf = AlignSelf.FLEX_END),
                                positionType = PositionType.ABSOLUTE
                        )
                )

        )
        ).applyStyle(style = Style(
                margin = EdgeValue(top = 10.unitReal(), left = 10.unitReal(), right = 10.unitReal()),
                size = Size(width = 90.unitPercent(), height = 400.unitReal()),
                cornerRadius = CornerRadius(20.0),
                backgroundColor = WHITE,
                flex = Flex(
                        alignSelf = AlignSelf.CENTER
                )
        )
        )
        )
    }

    fun createicon(nameIcon: String) = Image(
            ImagePath.Local.justMobile(nameIcon)
    )
}