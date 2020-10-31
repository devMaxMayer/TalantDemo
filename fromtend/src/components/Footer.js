import React from 'react'
import { View, StyleSheet, Text, Image  } from 'react-native'


export const Footer = () => {
    return (
        <View style={styles.footerContainer}>
            <View style={styles.item}>
                <Image
                       source={require('../../img/events.png')}
                       style={styles.image}
                />
            </View>
            <View style={styles.item}>
                <Image
                    source={require('../../img/messages.png')}
                    style={styles.image}
                />
            </View>
            <View style={styles.item}>
                <Image
                    source={require('../../img/contest.png')}
                    style={styles.image}
                />
            </View>
            <View style={styles.item}>
                <Image
                    source={require('../../img/profile.png')}
                    style={styles.image}
                />
            </View>
        </View>
    );
    
}


const styles = StyleSheet.create ({
    footerContainer: {
        width: '100%',
        flexDirection: "row",
        position: 'absolute',
        bottom:10,
        justifyContent: "space-evenly"
    },
    item: {
        flex: 0.25,
        paddingLeft: 30
    },
    image: { 
        width: 34,
        height: 34,
        resizeMode:"contain"
    }

})

