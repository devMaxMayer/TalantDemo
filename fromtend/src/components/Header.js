import React from 'react'
import { View, StyleSheet, Text, Image  } from 'react-native'

export const Header = props => {
    return (
        <View style={styles.header}>
            <Text style={styles.text}> {props.title}</Text>
        </View>

    )
}



const styles = StyleSheet.create ({
    header: {
        height: 80,
        width: '100%',
        backgroundColor: 'white',
        shadowColor: '#e6e6e6',
        shadowOffset: {
            width: 0,
            height: 6,
        },
        shadowOpacity: 0.39,
        shadowRadius: 8.30,
        elevation: 13,
    },
    text: {
        flex: 1,
        fontFamily: 'Roboto',
        fontStyle: 'normal',
        fontSize: 24,
        lineHeight: 28,
        paddingBottom: 10,
        paddingTop:40,
        paddingLeft:10
    },
    image: {
        flex: 1,
        paddingBottom: 20,
        paddingTop:30,
        paddingLeft:278,
        width: 20,
        height: 20
    }

})