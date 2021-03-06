package br.com.example.simple.screen

import br.com.example.simple.constants.*
import br.com.zup.beagle.core.CornerRadius
import br.com.zup.beagle.core.Style
import br.com.zup.beagle.ext.applyFlex
import br.com.zup.beagle.ext.applyStyle
import br.com.zup.beagle.ext.unitPercent
import br.com.zup.beagle.ext.unitReal
import br.com.zup.beagle.widget.action.Navigate
import br.com.zup.beagle.widget.action.Route
import br.com.zup.beagle.widget.core.*
import br.com.zup.beagle.widget.layout.Container
import br.com.zup.beagle.widget.layout.Screen
import br.com.zup.beagle.widget.layout.ScreenBuilder
import br.com.zup.beagle.widget.navigation.Touchable
import br.com.zup.beagle.widget.ui.*

class LoginScreen : ScreenBuilder {

    override fun build(): Screen {
        return Screen(child = Container(
                children = listOf(
                        image,
                        emailTextInput,
                        passwordTextInput,
                        passwordButton,
                        containerButton
                )
        ).applyStyle(Style(
                flex = Flex(alignItems = AlignItems.CENTER,
                        justifyContent = JustifyContent.CENTER,
                        grow = 1.0)
        )
        )
        )
    }

    private val image = Image(path = ImagePath.Local.justMobile(LOGO))
            .applyStyle(Style(
                    size = Size(width = 250.unitReal(), height = 150.unitReal())
            )
            )

    private val emailTextInput = TextInput(
            value = "",
            placeholder = "Email",
            type = TextInputType.EMAIL,
            styleId = STYLE_TEXT_INPUT
    ).applyStyle(style = Style(
            size = Size(width = 85.unitPercent(), height = 7.unitPercent()),
            margin = EdgeValue(top = 50.unitReal())
    )
    )

    private val passwordTextInput = TextInput(
            value = "",
            placeholder = "Senha",
            type = TextInputType.PASSWORD,
            styleId = STYLE_TEXT_INPUT
    ).applyStyle(style = Style(
            size = Size(width = 85.unitPercent(), height = 7.unitPercent()),
            margin = EdgeValue(top = 20.unitReal())
    )
    )

    private val passwordButton = Container(
            children = listOf(
                    Touchable(
                            child = Text(
                                    text = "Esqueci minha senha",
                                    styleId = STYLE_TEXT_BOLD_SYSTEM_16,
                                    textColor = BLUE
                            ).applyFlex(
                                    flex = Flex(alignSelf = AlignSelf.FLEX_START)
                            ),
                            onPress = listOf(
                                    Navigate.PushView(route = Route.Remote(url = "/password"))
                            )
                    )
            )
    ).applyStyle(
            Style(
                    margin = EdgeValue(top = 10.unitReal()),
                    size = Size(width = 85.unitPercent(), height = 7.unitPercent())
            )
    )

    private val loginButton = Button(
            text = "Entrar",
            styleId = STYLE_BUTTON_WHITE_SYSTEM_BOLD_16,
            onPress = listOf(
                    Navigate.OpenNativeRoute(route = "home")
            )
    ).applyStyle(style = Style(
            size = Size(width = 180.unitReal(), height = 40.unitReal()),
            cornerRadius = CornerRadius(radius = 10.0),
            flex = Flex(alignSelf = AlignSelf.CENTER),
            backgroundColor = BLUE
    )
    )

    private val signUpButton = Button(
            text = "Cadastrar",
            styleId = STYLE_BUTTON_WHITE_SYSTEM_BOLD_16,
            onPress = listOf(
                    Navigate.PushView(route = Route.Remote(url = "/register"))
            )
    ).applyStyle(style = Style(
            size = Size(width = 85.unitPercent(), height = 40.unitReal()),
            margin = EdgeValue(all = 10.unitReal()),
            cornerRadius = CornerRadius(radius = 10.0),
            flex = Flex(alignSelf = AlignSelf.CENTER),
            backgroundColor = BLUE
    )
    )

    private val containerButton = Container(
            children = listOf(
                    loginButton,
                    signUpButton
            )
    ).applyStyle(style = Style(
            margin = EdgeValue(top = 20.unitPercent()),
            size = Size(width = 100.unitPercent(), height = 30.unitPercent()),
            flex = Flex(justifyContent = JustifyContent.SPACE_BETWEEN, grow = 1.0)
    )
    )
}