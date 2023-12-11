package com.bilalberekgm.superheroapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.bilalberekgm.superheroapp.model.Hero


@Composable
fun HeroListItem(
    modifier: Modifier = Modifier,
    hero:Hero
){
   Card(
       modifier = modifier,

       elevation = CardDefaults.cardElevation(2.dp)
   ) {
       HeroInfo(
           hero.nameRes,
           hero.descriptionRes,
           hero.imageRes
       )
   }
}

@Composable
 private fun HeroInfo(
    title: Int,
    description: Int,
    imageRes: Int
){
    Row(
        modifier = Modifier
            .padding(
                16.dp
            )
            .sizeIn(minHeight = 72.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier
                .weight(1f),
        ){
            Text(text = stringResource(id = title ),
                modifier = Modifier,
                style = MaterialTheme.typography.displaySmall)
            Text(text = stringResource(id = description),
                modifier = Modifier,
                style = MaterialTheme.typography.bodyLarge
              )
        }

        Spacer(modifier = Modifier.width(16.dp))
       ImageSource(imageRes = imageRes )
    }

}

@Composable
private fun ImageSource(
    imageRes: Int
){

    Box(
            modifier = Modifier
                .size(72.dp, 72.dp)
                .clip(MaterialTheme.shapes.small),

    ) {

        Image(
            painter = painterResource(id = imageRes),
            contentDescription = null,
            alignment = Alignment.TopCenter,
            contentScale = ContentScale.FillWidth
        )
    }

}