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
        height: '100%',
        width: '100%',
        flexDirection: "row",
        //position: 'absolute',

        //bottom:10,
        justifyContent: 'space-between',
        alignItems: 'center',
    },
    item: {
        flex: 1,
        padding: 30,
        flexDirection: "row",
        alignItems:'center',
        justifyContent: 'center'
    },
    image: {
        flex: 1,

        resizeMode: 'contain'
    }

})
