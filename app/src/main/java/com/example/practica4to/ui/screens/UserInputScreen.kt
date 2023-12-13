package com.example.practica4to.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practica4to.R
import com.example.practica4to.data.UserDataUiEvents
import com.example.practica4to.ui.AvatarCard
import com.example.practica4to.ui.ButtonComponent
import com.example.practica4to.ui.TextComponent
import com.example.practica4to.ui.TextFieldComponent
import com.example.practica4to.ui.TopBar
import com.example.practica4to.ui.UserInputViewModel

@Composable
fun UserInputScreen(userInputViewModel: UserInputViewModel) {
    Surface(
        modifier = Modifier.fillMaxSize()) {
           Column(modifier= Modifier
               .fillMaxSize()
               .padding(18.dp)
           )
           {
               TopBar("Hello there 😀")

               TextComponent(
                   textValue = "Let's learn about You !", 
                   textSize = 24.sp
               )

               Spacer(modifier = Modifier.size(20.dp))

               TextComponent(
                   textValue = "This app will prepare a details page based on input provided by you ! ",
                   textSize =18.sp)

               Spacer(modifier = Modifier.size(60.dp))

               TextComponent(textValue = "Name", textSize = 18.sp)

               Spacer(modifier = Modifier.size(10.dp))

               TextFieldComponent(onTextChanged = {
                   userInputViewModel.onEvent(
                       UserDataUiEvents.UserNameEntered(it)
                   )
               })

               Spacer(modifier = Modifier.size(20.dp))

               TextComponent(textValue = "What do you like..?", textSize =18.sp )

               Spacer(modifier = Modifier.size(10.dp))

               Row (modifier = Modifier.fillMaxWidth()){
                   AvatarCard(image = R.drawable.eva1, avatarSelected = {
                       userInputViewModel.onEvent(
                           UserDataUiEvents.AnimalSelected(it)
                       )
                   }, selected = userInputViewModel.uiState.value.animalSelected=="Avatar1")
                   AvatarCard(image = R.drawable.eva2, avatarSelected = {
                       userInputViewModel.onEvent(
                           UserDataUiEvents.AnimalSelected(it)
                       )
                   },selected = userInputViewModel.uiState.value.animalSelected=="Avatar2")


               }

               Spacer(modifier = Modifier.weight(1f))

            if(userInputViewModel.isValidState()){
                ButtonComponent(
                    goToDetailsScreen = {
                        println("========ComingHere")
                        println("========${userInputViewModel.uiState.value.nameEntered} and ${userInputViewModel.uiState.value.animalSelected}")
                    }
                )
            }


           }
        }
}

@Preview
@Composable
fun UserInputScreenPreview(){
    UserInputScreen(UserInputViewModel())
}