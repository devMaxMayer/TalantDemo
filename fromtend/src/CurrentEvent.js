import React from 'react'
import { View, StyleSheet, Text, Image, TouchableOpacity  } from 'react-native'
import {Footer} from './components/Footer';

export const CurrentEvent = props => {
    return (
        <View style={styles.container}>
            <View style={styles.event}>
                <View style={{alignItems: "center", paddingTop:40}}>
                    <Image style={styles.avatar}
                           source={require('../img/event.png')}
                           style={{ width: 120, height: 120}}
                    />
                    <Text style={styles.name}>{props.name}</Text>
                    <Text style={styles.dateEvent}>{props.date} • {props.time} • {props.type}</Text>
                    <Text style={styles.dateEvent}>{props.city} • {props.place}</Text>
                    <TouchableOpacity style={styles.buttonDone} activeOpacity={0.5}>
                        <Image
                            source={require('../img/done.png')}
                            style={styles.buttonImageIconStyle}
                        />
                        <View style={styles.buttonIconSeparatorStyle} />
                        <Text style={styles.buttonText}>You’re attending</Text>
                    </TouchableOpacity>
                    <View style={styles.subTitle}>
                        <Text style={styles.subTitleText} >Event Chat</Text>
                    </View>
                </View>
            </View>
            <View style={styles.eventsChats}>
                <View style={styles.eventChat}>
                    <View style={styles.logoEventChat} >
                        <Image
                               source={require('../img/leader.png')}
                               style={{ width: 60, height: 60}}
                        />
                    </View>
                    <View style={styles.EventChatName}>
                        <Text style={{ }}>Arseny Nikitin
                        </Text>
                        <Text style={{ }}>Event Lead
                        </Text>
                    </View>
                </View>
                <View style={styles.eventChat}>
                    <View style={styles.logoEventChat} >
                        <Image
                            source={require('../img/event.png')}
                            style={{ width: 60, height: 60}}
                        />
                    </View>
                    <View style={styles.EventChatName}>
                        <Text style={{ }}>505 Fest
                        </Text>
                        <Text style={{ }}>Official Event Chat
                        </Text>
                    </View>
                </View>
            </View>
            <Footer />
        </View>

    )
}

const styles = StyleSheet.create ({

    container: {
        height: '100%',
        width: '100%',

    },
    event:{
        height: 350,
        width: '100%',
        shadowColor: '#e6e6e6',
        shadowOffset: {
            width: 0,
            height: 6,
        },
        shadowOpacity: 0.39,
        shadowRadius: 8.30,

        elevation: 13
    },
    avatar:{
        alignItems: 'center',
        justifyContent: 'center'
    },
    name: {
        fontFamily: 'Roboto',
        fontStyle: 'normal',
        fontSize: 24,
        lineHeight: 35,
        paddingTop:5,
        paddingBottom:5
    },
    dateEvent: {
        alignItems: 'center',
        fontFamily: 'Roboto',
        fontStyle: 'normal',
        fontSize: 17,
        lineHeight: 21,
    },
    subTitle: {
        height: 300,
        width: '100%',
        flex: 1,
        alignItems: 'flex-start',
        justifyContent: 'center',
        lineHeight: 28,
        paddingTop: 15,
        paddingLeft:20,
        paddingBottom: 20
    },
    subTitleText: {
        fontFamily: 'Roboto',
        fontStyle: 'normal',
        fontSize: 24
    },
    buttonDone: {
        flexDirection: 'row',
        alignItems: 'center',
        backgroundColor: '#2386E0',
        borderWidth: 0.5,
        height: 40,
        margin: 5,
        width: 250,
        borderColor: '#fff',
        shadowColor: '#e6e6e6',
        shadowOffset: {
            width: 0,
            height: 6,
        },
        shadowOpacity: 0.39,
        shadowRadius: 8.30,
        elevation: 13,
    },
    buttonText: {
        color: '#fff',
        marginBottom: 4,
        marginLeft: 10,
        fontFamily: 'Roboto',
        fontStyle: 'normal',
    },
    buttonImageIconStyle: {
        padding: 10,
        margin: 5,
        height: 13.4,
        width: 17.6,
        resizeMode: 'stretch',
    },
    eventChat:{
        flexDirection:'row',
        alignItems:'center',
        paddingTop: 20
    },
    logoEventChat:{
        paddingLeft: 20,
        flex:0.2,

    },
    EventChatName:{
        flex:0.8,
        justifyContent:'space-evenly'
    }

})